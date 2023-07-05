package com.eviden.onecloud.models;

// Registration entity with (title, role, totalYearOfExperience, skills, availability)
// with RegistrationId as a primary key

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registration")
public class Registration {

    // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registrationId;

    //Title
    private String title;

    // role
    @ElementCollection
    private List<String> role;

    // total years of experience
    private Integer totalYearOfExperience;

    //skills
    @ElementCollection
    private List<String> skills;

    // availability
    private String availability;

}