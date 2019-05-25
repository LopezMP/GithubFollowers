package edu.upc.dsa.githubfollowers;

class User {

    String login;
    String avatar_url;
    String following;
    String public_repos;
    public User(String login, String avatar_url, String following, String public_repos){
        this.login=login;
        this.avatar_url=avatar_url;
        this.following=following;
        this.public_repos=public_repos;
    }


    @Override
    public String toString() {
        return "User{"; /* +
                "id="
                ", username='" + login + '\'' +
                ", password="'\'' +
                '}';
                */
    }
}
