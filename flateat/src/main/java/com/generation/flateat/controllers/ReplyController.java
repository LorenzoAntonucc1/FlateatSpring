package com.generation.flateat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.reply.ReplyDtoRPost;
import com.generation.flateat.model.dtoservices.ReplyConverter;
import com.generation.flateat.model.entities.Reply;
import com.generation.flateat.model.repositories.ReplyRepository;
import com.generation.flateat.model.repositories.UserRepository;

@RestController
public class ReplyController 
{
    @Autowired
    ReplyRepository repo;

    @Autowired
    UserRepository uRepo;

    @Autowired
    ReplyConverter conv;

    @GetMapping("/replies")
    public List<Reply> getAllReplies()
    {
        return repo.findAll()
                .stream()
                .map(e -> conv.dtoToReply(e))
                .toList();
    }

    @PostMapping("/replies")
    public Reply saveReply(@RequestBody ReplyDtoRPost dto)
    {
        return repo.save(conv.dtoToReply(dto));
    }

    @DeleteMapping("/replies/{id}")
    public void deleteReply(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }
}
