import com.example.profiles.*;

public class TryIt {
	public static void main(String[] args) {
		ProfileService svc = new ProfileService();
		UserProfile p = svc.createMinimal("u1", "a@b.com");
		System.out.println("Before: " + p.getEmail());
		// p.setEmail("evil@example.com"); // setters removed — object is immutable now
		System.out.println("After:  " + p.getEmail());
		System.out.println("=> Object remains unchanged; updates create new instances.");

		UserProfile p2 = svc.withDisplayName(p, "Alice Wonderland");
		System.out.println("Original displayName: " + p.getDisplayName());
		System.out.println("New displayName:      " + p2.getDisplayName());
	}
}
