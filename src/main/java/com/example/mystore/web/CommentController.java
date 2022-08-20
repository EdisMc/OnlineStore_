package com.example.mystore.web;

import com.example.mystore.model.binding.CommentBindingDto;
import com.example.mystore.model.entity.CommentEntity;
import com.example.mystore.securityUser.ShopUserDetails;
import com.example.mystore.service.CommentsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
@RequestMapping("comments/")
public class CommentController {

    private final CommentsService commentsService;

    public CommentController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("/add/{id}")
   public String addComment(@PathVariable Long id,
                            @Valid CommentBindingDto commentBindingDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            @AuthenticationPrincipal ShopUserDetails sellAndBuyUser)
                            {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("commentBindingDto", commentBindingDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.commentBindingDto", bindingResult);
            return String.format("redirect:/products/info/%d",id);
        }
          CommentEntity newComment =
                  this.commentsService.saveComment(commentBindingDto,id,sellAndBuyUser.getId());
        return String.format("redirect:/products/info/%d",id);
   }

}
