package com.njcrain.healthtrackerbackend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

//Class model structure for users.
@Entity
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    @JsonIgnore
    private String password;
    private String avatarUri;
    @OneToMany(mappedBy = "user")
    private List<Exercise> exercises;
    private int homePageVisits;
    private int clickerScore;

    public AppUser(String username, String password, String avatarUri, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.avatarUri = avatarUri;
    }

    public AppUser() {}

    public String toString() {
        return this.username + " -(username)";
    }

    public long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAvatarUri() {
        return this.avatarUri;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public int getHomePageVisits() {
        return homePageVisits;
    }

    public void setHomePageVisits(int homePageVisits) {
        this.homePageVisits = homePageVisits;
    }

    public int getClickerScore() {
        return clickerScore;
    }

    public void setClickerScore(int clickerScore) {
        this.clickerScore = clickerScore;
    }
}
