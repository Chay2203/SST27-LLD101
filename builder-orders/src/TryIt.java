import com.example.orders.*;
import java.util.List;

public class TryIt {
    public static void main(String[] args) {
        System.out.println("=== Order Builder Pattern Demo ===\n");
        
        // Create order lines
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);
        
        // Build order using the Builder pattern
        Order order = new Order.Builder("o2", "a@b.com")
                .addLine(l1)
                .addLine(l2)
                .discountPercent(10)
                .expedited(false)
                .notes("Sample order")
                .build();
        
        // Display order details
        System.out.println("Order Details:");
        System.out.println("  ID: " + order.getId());
        System.out.println("  Customer Email: " + order.getCustomerEmail());
        System.out.println("  Lines count: " + order.getLineCount());
        System.out.println("  Discount: " + order.getDiscountPercent() + "%");
        System.out.println("  Expedited: " + order.isExpedited());
        System.out.println("  Notes: " + order.getNotes());
        
        // Display pricing information
        System.out.println("\nPricing Information:");
        System.out.println("  Total before discount: " + order.totalBeforeDiscount() + " cents");
        if (order.hasDiscount()) {
            System.out.println("  Discount amount: " + order.getDiscountAmount() + " cents");
        }
        System.out.println("  Total after discount: " + order.totalAfterDiscount() + " cents");
        
        // Demonstrate immutability
        System.out.println("\nImmutability Demonstration:");
        System.out.println("  Original total: " + order.totalAfterDiscount() + " cents");
        
        // Note: OrderLine is now immutable, so setQuantity() no longer exists
        // This prevents the mutability leak that was present in the original code
        
        System.out.println("  Total remains stable: " + order.totalAfterDiscount() + " cents");
        System.out.println("  => Order totals remain stable due to immutability and defensive copies.");
        
        // Show that the order lines list is unmodifiable
        System.out.println("\nList Immutability Test:");
        try {
            order.getLines().add(new OrderLine("C", 1, 150));
            System.out.println("  ✗ Added new line (this shouldn't happen)");
        } catch (UnsupportedOperationException e) {
            System.out.println("  ✓ Cannot modify order lines - list is unmodifiable");
        }
        
        // Show that individual order lines are immutable
        System.out.println("\nOrderLine Immutability:");
        System.out.println("  Original line 1 quantity: " + l1.getQuantity());
        // l1.setQuantity(999); // This would cause compilation error
        System.out.println("  Line 1 quantity remains: " + l1.getQuantity());
        
        System.out.println("\n=== Demo Complete ===");
    }
}
