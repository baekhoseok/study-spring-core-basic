package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.order.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();


    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    @Test
    public void rateDiscount() throws Exception {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);


        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1500);
    }

    @DisplayName("VIP가 아니면 10% 할인이 적용되지 않아야 한다.")
    @Test
    public void donot_rateDiscount() throws Exception {
        Long memberId = 2L;
        Member member = new Member(memberId, "memberBasic", Grade.BASIC);


        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }
}