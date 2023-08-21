package ecom.com.Coupon.Service.Service;

import ecom.com.Coupon.Service.Repositroy.CouponRepository;
import ecom.com.Coupon.Service.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public boolean createCoupon(Coupon coupon) {
        try {
            couponRepository.save(coupon);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Coupon> getActiveCoupons(String brand, String category, LocalDate currentDate) {
        List<Coupon> data = couponRepository.findByBrandAndCategoryAndOfferStartDateBeforeAndOfferEndDateAfterAndIsActiveIsTrue(
                brand, category, currentDate, currentDate);
        return data;
    }

    public boolean updateCoupon(Long id, double newPercentage) {
        try {
            Coupon coupon = couponRepository.findById(id).orElse(null);
            if (coupon != null) {
                coupon.setOfferPercentage(newPercentage);
                couponRepository.save(coupon);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean disableCoupon(Long id) {
        try {
            Coupon coupon = couponRepository.findById(id).orElse(null);
            if (coupon != null) {
                coupon.setActive(false);
                couponRepository.save(coupon);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
