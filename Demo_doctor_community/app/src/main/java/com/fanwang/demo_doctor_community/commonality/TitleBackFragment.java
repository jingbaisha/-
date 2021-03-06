package com.fanwang.demo_doctor_community.commonality;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;


/**
 * 常用带返回按钮的Title标题布局 功能说明 </p>作者: TS 创建日期：2014-10-13下午1:36:34 示例：
 */
public class TitleBackFragment extends ChildFragment implements OnClickListener {
	/** 左边文本组件 */
	private TextView leftText;
	/** 左边图片组件 */
	private ImageView leftImageView;
	/** 右边文本组件 */
	private TextView rightText;
	/** 右边图片组件 */
	private ImageView rightImageView;
	/** 标题组件 */
	private TextView middleText;

	/** 左边的内容 */
	private String leftContent = "";
	/** 左边的图标 */
	private int leftImg = -1;
	/** 右边的内容 */
	private String rightContent = "";
	/** 右边的图标 */
	private int rightImg = -1;
	/** 标题内容 */
	private String titleContent = "";
	/** 控制title的背景颜色 */
	private String bgColor = "#f6f6f6";

	private LinearLayout title_fragment_bg;
	private LinearLayout title_right_layout;
	private LinearLayout title_left_layout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle args = getArguments();
		if (args != null) {
			leftContent = args.getString("leftContent");
			titleContent = args.getString("titleContent");
			rightContent = args.getString("rightContent");
			rightImg = args.getInt("rightImg");
			leftImg = args.getInt("leftImg");
			bgColor = args.getString("bgColor");
		}

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.common_title_back_fra_layout, container, false);
		initView(view);
		return view;
	}

	/**
	 * 功能说明：初始化title的数据
	 * <p >
	 * 作者：ts 创建日期:2014-10-29 参数：
	 * 
	 * @param titleContent
	 *            标题文字
	 * @param bgColor
	 *            title的背景颜色（例如：为""则默认"#3e3c47"）
	 * @return 示例：
	 */
	public TitleBackFragment newInstance(String titleContent, String bgColor) {
		TitleBackFragment fragment = new TitleBackFragment();
		Bundle args = new Bundle();
		args.putString("titleContent", titleContent);
		args.putString("bgColor", bgColor);
		fragment.setArguments(args);

		return fragment;
	}

	/**
	 * 功能说明：初始化title的数据
	 * <p >
	 * 作者：ts 创建日期:2014-10-29 参数：
	 * 
	 * @param titleContent
	 *            标题文字
	 * @param rightContent
	 *            右边文字
	 * @param bgColor
	 *            title的背景颜色（例如：为""则默认"#3e3c47"）
	 * @return 示例：
	 */
	public TitleBackFragment newInstance(String leftContent, String titleContent, String rightContent, String bgColor) {
		TitleBackFragment fragment = new TitleBackFragment();
		Bundle args = new Bundle();
		args.putString("leftContent", leftContent);
		args.putString("titleContent", titleContent);
		args.putString("rightContent", rightContent);
		args.putString("bgColor", bgColor);
		fragment.setArguments(args);
		return fragment;
	}



	/**
	 * 功能说明：初始化title的数据
	 * <p >
	 * 作者：ts 创建日期:2014-10-29 参数：
	 * 
	 * @param leftContent
	 *            左边文字
	 * @param leftImg
	 *            右边图标
	 * @param titleContent
	 *            标题文字
	 * @param rightContent
	 *            右边文字
	 * @param rightImg
	 *            右边图标
	 * @param bgColor
	 *            title的背景颜色（例如：为""则默认"#3e3c47"）
	 * @return 示例：
	 */

	public TitleBackFragment newInstance(String leftContent,int leftImg, String titleContent, String rightContent,int rightImg, String bgColor) {
		TitleBackFragment fragment = new TitleBackFragment();
		Bundle args = new Bundle();
		args.putString("leftContent", leftContent);
		args.putInt("leftImg", leftImg);
		args.putString("titleContent", titleContent);
		args.putString("rightContent", rightContent);
		args.putInt("rightImg", rightImg);
		args.putString("bgColor", bgColor);
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void showFragment(Fragment fragment) {

	}

	@Override
	public void initView(View view) {
		leftText = (TextView) view.findViewById(R.id.title_left_text);
		leftImageView = (ImageView) view.findViewById(R.id.title_left_img);
		middleText = (TextView) view.findViewById(R.id.title_content_show);
		rightText = (TextView) view.findViewById(R.id.title_right_text);
		rightImageView = (ImageView) view.findViewById(R.id.title_right_img);

		title_left_layout = (LinearLayout) view.findViewById(R.id.title_left_layout);
		title_right_layout = (LinearLayout) view.findViewById(R.id.title_right_layout);
		title_fragment_bg = (LinearLayout) view.findViewById(R.id.title_fragment_bg);

		title_left_layout.setOnClickListener(this);
		middleText.setOnClickListener(this);
		title_right_layout.setOnClickListener(this);
		// 设置左边标题
		if (!TextUtils.isEmpty(leftContent)) {
			leftText.setText(leftContent);
			leftText.setVisibility(View.VISIBLE);
		}else {
			leftText.setVisibility(View.GONE);
		}

		// 设置左边图标
		if (leftImg != -1) {
			leftImageView.setImageResource(leftImg);
			leftImageView.setVisibility(View.VISIBLE);
		}
		// 设置标题
		if (!TextUtils.isEmpty(titleContent)) {
			middleText.setText(titleContent);
		}

		// 设置右边标题
		if (!TextUtils.isEmpty(rightContent)) {
			rightText.setText(rightContent);
			rightText.setVisibility(View.VISIBLE);
		}else {
			rightText.setVisibility(View.GONE);
		}
		// 设置右边图标
		if (rightImg != -1) {
			rightImageView.setImageResource(rightImg);
			rightImageView.setVisibility(View.VISIBLE);
		}

		// 设置title的背景颜色
		if (!TextUtils.isEmpty(bgColor)) {
			title_fragment_bg.setBackgroundColor(Color.parseColor(bgColor));
		}

	}

	@Override
	public void setData() {

	}

	@Override
	public void requestData(boolean isShow) {

	}

	public void isShow(boolean ishow){
		if(title_fragment_bg!=null){
			if(ishow){
				title_fragment_bg.setVisibility(View.VISIBLE);
			}else{
				title_fragment_bg.setVisibility(View.GONE);
			}
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_left_layout:

			getActivity().finish();

			if(listenerAnim!=null){
				listenerAnim.AnimOnClik();

			}
			if (listener != null) {
				listener.onClikLeft();
			}

			break;
		case R.id.title_content_show:
			if (listener != null) {
				listener.onClikMiddle();

			}
			break;
		case R.id.title_right_layout:
			if (listener != null) {
				listener.onClikRight();
			}
			break;

		default:
			break;
		}
	}

	private TitleOnClikListener listener;
	private BackAnimOnClikListener listenerAnim;

	public interface TitleOnClikListener {
		/** title右边第3个的点击事件回调 */
		public void onClikRight();

		/** title右边第2个的点击事件回调 */
		public void onClikMiddle();

		/** title右边第1个的点击事件回调 */
		public void onClikLeft();

	}
	public interface BackAnimOnClikListener {
	
		/** 返回实现动画效果 */
		public void AnimOnClik();
		
	}

	/**
	 * 功能说明：Title右边文字的点击监听 作者：ts 创建日期:2014-11-14 参数：
	 * 
	 * @param listener
	 */
	public void setTitleOnClikListener(TitleOnClikListener listener) {
		this.listener = listener;
	}
	/**
	 * 功能说明：Title右边文字的点击监听 作者：ts 创建日期:2014-11-14 参数：
	 * 
	 *
	 */
	public void setTitleOnClikListener(BackAnimOnClikListener listenerAnim) {
		this.listenerAnim = listenerAnim;
	}

}
