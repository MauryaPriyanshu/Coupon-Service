package ecom.com.Coupon.Service.Repositroy;

import ecom.com.Coupon.Service.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    List<Coupon> findByBrandAndCategoryAndOfferStartDateBeforeAndOfferEndDateAfterAndIsActiveIsTrue(
            String brand, String category, LocalDate startDate, LocalDate endDate);
}
