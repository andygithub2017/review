package review;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import review.exception.CurseWordseException;
import review.exception.RateException;
import review.iface.CustomerReview;
import review.iface.ReviewCurseWordsFilter;

public class ReviewCurseWordsFilterInterceptor implements MethodBeforeAdvice {
	private ReviewCurseWordsFilter reviewCurseWordsFilter;

	public ReviewCurseWordsFilter getReviewCurseWordsFilter() {
		return reviewCurseWordsFilter;
	}

	public void setReviewCurseWordsFilter(ReviewCurseWordsFilter reviewCurseWordsFilter) {
		this.reviewCurseWordsFilter = reviewCurseWordsFilter;
	}

	public void before(Method method, Object[] object, Object target) throws Throwable {

		for (int x = 0; x < object.length; x++) {

			if (object[0] instanceof CustomerReview) {
				CustomerReview arg = (CustomerReview) object[x];

				if (reviewCurseWordsFilter.containCurseWords(arg.getReview())) {
					arg.addException(new CurseWordseException());
				}

				if (0 > arg.getRate()) {
					arg.addException(new RateException());
				}
			}
		}

	}
}
