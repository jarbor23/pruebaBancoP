package com.devskiller.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ITEMS")
public class Item {

  @Id
  @GeneratedValue
  private Long id;
  @NotEmpty
  private String title;
  private String description;
  @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
  Set<Review> reviews = new HashSet<>();

  public Item() {
  }

  public Item(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public Set<Review> getReviews() {
    return reviews;
  }

  public void addReview(Review review) {
    reviews.add(review);
    review.setItem(this);
  }

  @Override
  public String toString() {
    return "\nItem{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", reviews=" + reviews +
        '}';
  }
}
