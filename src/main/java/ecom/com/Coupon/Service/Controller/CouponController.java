package ecom.com.Coupon.Service.Controller;

import ecom.com.Coupon.Service.Service.CouponService;
import ecom.com.Coupon.Service.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @PostMapping("/create")
    public ResponseEntity<String> createCoupon(@RequestBody Coupon coupon) {
        boolean success = couponService.createCoupon(coupon);
        if (success) {
            return ResponseEntity.ok("Coupon created successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to create coupon");
        }
    }

    @GetMapping("/active")
    public List<Coupon> getActiveCoupons(
            @RequestParam String brand, @RequestParam String category, @RequestParam LocalDate currentDate) {
//        LocalDate date = LocalDate.parse(currentDate);
        return couponService.getActiveCoupons(brand, category, currentDate);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCoupon(@PathVariable Long id, @RequestParam double newPercentage) {
        boolean success = couponService.updateCoupon(id, newPercentage);
        if (success) {
            return ResponseEntity.ok("Coupon updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update coupon");
        }
    }

    @PutMapping("/disable/{id}")
    public ResponseEntity<String> disableCoupon(@PathVariable Long id) {
        boolean success = couponService.disableCoupon(id);
        if (success) {
            return ResponseEntity.ok("Coupon disabled successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to disable coupon");
        }
    }
}
