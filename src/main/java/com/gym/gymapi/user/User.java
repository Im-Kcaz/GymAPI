package com.gym.gymapi.user;

import com.gym.gymapi.athlete.Athlete;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "binary(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "user_name")
    private String userName;

    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "athlete_id", referencedColumnName = "id")
    private Athlete athlete;
}
