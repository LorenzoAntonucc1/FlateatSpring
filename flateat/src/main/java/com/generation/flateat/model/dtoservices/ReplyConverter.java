package com.generation.flateat.model.dtoservices;

import org.springframework.stereotype.Service;

import com.generation.flateat.model.dto.reply.ReplyDtoRPost;
import com.generation.flateat.model.entities.Reply;

@Service
public class ReplyConverter 
{
    public Reply dtoToReply(ReplyDtoRPost e)
    {
        return Reply.builder()
            .id(e.getId())
            .text(e.getText())
            .ticket(e.getTicket())
            .build();
    }

    public Reply dtoToReply(Reply e)
    {
        return Reply.builder()
            .id(e.getId())
            .text(e.getText())
            .ticket(e.getTicket())
            .build();
    }

    public ReplyDtoRPost replyToDto(Reply r)
    {
        return ReplyDtoRPost.builder()
            .id(r.getId())
            .text(r.getText())
            .ticket(r.getTicket())
            .build();
    }
}
