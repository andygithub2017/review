package review.filter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import review.iface.ReviewCurseWordsFilter;

public class ReviewCurseWordsFilterImpl implements ReviewCurseWordsFilter {

	private List curseWords = null;
	private Pattern curseWordPattern = null;

	public List getCurseWords() {
		return curseWords;
	}

	public void setCurseWords(List curseWordsList) {
		this.curseWords = curseWordsList;
		buildRegex();
	}

	private void buildRegex() {
		StringBuffer sb = new StringBuffer();
		int size = curseWords.size();

		for (int i = 0; i < size; i++) {
			if (i != 0) {
				sb.append("|");
			}
			sb.append("(");
			sb.append(curseWords.get(i));
			sb.append(")");

		}

		curseWordPattern = Pattern.compile(sb.toString(), Pattern.CASE_INSENSITIVE);
	}

	public Pattern getCurseWordsPattern() {
		return curseWordPattern;
	}

	public void setCurseWordsPattern(Pattern curseWordPattern) {
		this.curseWordPattern = curseWordPattern;
	}

	public boolean containCurseWords(String data) {
		Matcher m = curseWordPattern.matcher(data);
		return m.find();
	}

}
