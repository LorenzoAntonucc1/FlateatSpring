package com.generation.flateat.model.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Object Ticket | 1 - N User")
public class Ticket 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Primary Key | > 0")
    private Integer id;

    @Schema(description = "Ticket accurate description (for SuperUser, from User)")
    private String text;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @Schema(description = "Foreign Key | user_id")
    private User userOfTicket;

    @JsonIgnore
    @OneToMany(mappedBy = "ticket",fetch = FetchType.EAGER)
    private Set<Reply> replies;
}
