package com.javalanguagezone.interviewtwitter.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Data
@NoArgsConstructor(access = PRIVATE)
public class Tweet {
  protected static final int TWEET_MAX_LENGTH = 140;
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(nullable = false, length = TWEET_MAX_LENGTH)
  private String content;

  @ManyToOne(optional = false)
  private User author;

  public Tweet(String content, User author) {
    this.content = content;
    this.author = author;
  }

  public Long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public User getAuthor() {
    return author;
  }

  public boolean isValid() {
    return author != null && content != null && !content.isEmpty() && content.length() <= TWEET_MAX_LENGTH;
  }

  @Override
  public String toString() {
    return "Tweet{" +
      "id=" + id +
      ", content='" + content + '\''+
      '}';
  }
}
