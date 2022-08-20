package com.example.mystore.web;

import com.example.mystore.model.binding.MessageBindingModel;
import com.example.mystore.model.entity.MessageEntity;
import com.example.mystore.model.entity.ProductEntity;
import com.example.mystore.model.view.messages.MessageChatViewModel;
import com.example.mystore.model.view.productViews.ProductChatViewModel;
import com.example.mystore.model.view.userViews.UserChatViewModel;
import com.example.mystore.securityUser.ShopUserDetails;
import com.example.mystore.service.MessageService;
import com.example.mystore.service.ProductService;
import com.example.mystore.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/messages")
public class MessageController {
    private final UserService userService;
    private final MessageService messageService;
    private final ProductService productService;

    public MessageController(UserService userService, MessageService messageService, ProductService productService) {
        this.userService = userService;
        this.messageService = messageService;
        this.productService = productService;
    }

    @ModelAttribute
    public MessageBindingModel messageBindingModel(){return new MessageBindingModel();}

    @ModelAttribute(name = "allMessages")
    public Set<MessageEntity> messages(){return new HashSet<>();}

    @ModelAttribute(name = "senders")
    public Set<UserChatViewModel> senders(){return new HashSet<>();}

    @GetMapping("/all")
    public String messages(Model model, @AuthenticationPrincipal ShopUserDetails sellAndBuyUser){

       Set<ProductChatViewModel> products =
               this.productService.getProductsFromChatsByUserByUserId(sellAndBuyUser.getId());

       model.addAttribute("products",products);

       return "messages-for-all-products";

    }

    @GetMapping("/products/{id}")
    public String getSenders(@PathVariable Long id,
                                  @AuthenticationPrincipal ShopUserDetails sellAndBuyUser,
                                  Model model){

        Set<UserChatViewModel> chatters =
                this.productService.
                        findProductChattersByProductIdAndSellerId(id, sellAndBuyUser.getId());

        if (chatters.size() == 0){
            ProductEntity product = this.productService.findById(id);
            model.addAttribute("seller",product.getSeller().getId());
        }

        model.addAttribute("senders",chatters);
        model.addAttribute("currentUser",this.userService.findById(sellAndBuyUser.getId()));
        model.addAttribute("productId",id);

        return "messages-for-product";
    }

    @GetMapping("/send/{senderId}/{productId}")
    public String getChatMessagesFromSender(@AuthenticationPrincipal ShopUserDetails sellAndBuyUser,
            Model model, @PathVariable Long productId, @PathVariable Long senderId){

        Set<MessageChatViewModel> allMessages = this.messageService.
                        findChatsMessagesByProductIdSenderIdReceiverId(productId,senderId,sellAndBuyUser.getId());

        model.addAttribute("allMessages",allMessages);
        model.addAttribute("chatWitUserId",senderId);

        return "messages-for-product";
    }

    @PostMapping("/send/{receiverId}/{productId}")
    public String sentMessage(@Valid MessageBindingModel messageBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, @PathVariable Long productId,
                              @PathVariable Long receiverId,
                              @AuthenticationPrincipal ShopUserDetails sellAndBuyUser){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("messageBindingModel", messageBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.messageBindingModel",
                    bindingResult);
            return "redirect:/products/info/" + productId ;
        }

        MessageEntity message = this.messageService.
                        createAndSave(messageBindingModel, productId, receiverId, sellAndBuyUser.getId());

        redirectAttributes.addFlashAttribute("isSend", true);

        return "redirect:/products/info/" + productId ;
    }

    @PostMapping("/send/{receiverId}/{productId}/{senderId}")
    public String sendMessageFromChat(@Valid MessageBindingModel messageBindingModel,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes,
                                      @PathVariable Long productId,
                                      @PathVariable Long receiverId,
                                      @PathVariable Long senderId,
                                      @AuthenticationPrincipal ShopUserDetails sellAndBuyUser){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("messageBindingModel", messageBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.messageBindingModel",
                    bindingResult);
            return "redirect:/messages/send/" + receiverId + "/" + productId ;
        }

        MessageEntity message =
                this.messageService.
                        createAndSave(messageBindingModel, productId, receiverId, sellAndBuyUser.getId());

        redirectAttributes.addFlashAttribute("isSend", true);

        return "redirect:/messages/send/" + receiverId + "/" + productId ;
    }

}
