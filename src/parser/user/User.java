package parser.user;

import java.util.List;

/**
 * Created by SuryaRajasekaran on 11/13/17.
 */
public class User {

    private String yelpingSince;
    private Votes votes;
    private Integer reviewCount;
    private String name;
    private String userId;
    private List<String> friends = null;
    private Integer fans;
    private Double averageStars;
    private String type;
    private Compliments compliments;
    private List<Object> elite = null;

    public String getYelpingSince() {
        return yelpingSince;
    }

    public void setYelpingSince(String yelpingSince) {
        this.yelpingSince = yelpingSince;
    }

    public Votes getVotes() {
        return votes;
    }

    public void setVotes(Votes votes) {
        this.votes = votes;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Double getAverageStars() {
        return averageStars;
    }

    public void setAverageStars(Double averageStars) {
        this.averageStars = averageStars;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Compliments getCompliments() {
        return compliments;
    }

    public void setCompliments(Compliments compliments) {
        this.compliments = compliments;
    }

    public List<Object> getElite() {
        return elite;
    }

    public void setElite(List<Object> elite) {
        this.elite = elite;
    }

}