package blogz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post extends Entity {

	private String title;
	private String body;
	private User author;
	private final Date created;
	private Date modified;
	private static final List<Post> allPosts = new ArrayList<Post>();
	
	public Post(String title, String body, User author) {
		super();
		this.title = title;
		this.body = body;
		this.author = author;
		this.created = new Date();
		this.modified = created;
		allPosts.add(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		this.modified = new Date();
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
		this.modified = new Date();
	}
	
	public User getAuthor() {
		return author;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public static List<Post> getPostsByUser(User user) {
		List<Post> postsByUser = new ArrayList<Post>();
		for (Post post : allPosts) {
			if (post.getAuthor().equals(user)) {
				postsByUser.add(post);
			}
		}
	return postsByUser;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
	
}
