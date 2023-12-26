package programmers1_task.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {
  private Long user_id;
  private String username;
  private int post_count;

  public Long getId(){
    return user_id;
  }

  public String getName(){
    return username;
  }

  public int getCount(){
    return post_count;
  }

  public Member(){}

  @JsonCreator
  public Member(@JsonProperty("user_id") Long user_id, @JsonProperty("username") String username, @JsonProperty("post_count") int post_count){
    this.user_id = user_id;
    this.username = username;
    this.post_count = post_count;
  }
  
}
