package com.wight.proxy.javaproxy;

/**
 * @author wight
 * @date 2021/11/22
 * @apiNote
 */
public class PersonBeanImpl implements PersonBean{
    String name;
    String gender;
    String interests;
    int rating;
    int ratingCount;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterest() {
        return interests;
    }

    @Override
    public int getHotOrNotRating() {
        if (ratingCount == 0) {
            return 0;
        }
        return (rating / ratingCount);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.rating += rating;
        ratingCount++;
    }
}
