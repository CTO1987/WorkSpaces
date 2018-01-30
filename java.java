    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mInitialView = new InitialView(view);
        // 请求手机权限
        PermissionsManager.getInstance().checkCallPhonePermissions(getActivity(), false);
        // 天气ui
        WeatherUtils.init();
        // 弹窗
        PopHome.initDialog(this, getActivity());
        // 检测密码
        mPresenter.checkPassword(getContext());
        // 初始化刷新
        mInitialView.trlView.startRefresh();
        return view;
    }
	
		//根据状态来判断显示相关时间
        switch (orderDetail.getResult().getDriverOrderWrapper().getOrderStatus()) {
            case 0:
                //待接单
                mInitialView.tvCreatedTime.setText("" + orderDetail.getResult().getDriverOrderWrapper().getCreateTime());
                mInitialView.llReceiveTime.setVisibility(View.GONE);
                mInitialView.llFinishTime.setVisibility(View.GONE);
                break;
            case 1:
                //已接单
                mInitialView.tvCreatedTime.setText(" " + orderDetail.getResult().getDriverOrderWrapper().getCreateTime());
                mInitialView.tvReceiveTime.setText(" " + orderDetail.getResult().getDriverOrderWrapper().getReceiveTime());
                mInitialView.llFinishTime.setVisibility(View.GONE);
                break;
            case 2:
                // 已完成
                mInitialView.tvCreatedTime.setText(" " + orderDetail.getResult().getDriverOrderWrapper().getCreateTime());
                mInitialView.tvReceiveTime.setText(" " + orderDetail.getResult().getDriverOrderWrapper().getReceiveTime());
                mInitialView.tvFinishTime.setText(" " + orderDetail.getResult().getDriverOrderWrapper().getFinishTime());
                break;
            case 3:
                //  已关闭
                mInitialView.tvCreatedTime.setText(" " + orderDetail.getResult().getDriverOrderWrapper().getCreateTime());
                mInitialView.tvReceiveTime.setText(" " + orderDetail.getResult().getDriverOrderWrapper().getReceiveTime());
                mInitialView.tvFinishTime.setText(" " + orderDetail.getResult().getDriverOrderWrapper().getFinishTime());
                mInitialView.llFinishTime.setVisibility(View.GONE);
                mInitialView.llReceiveTime.setVisibility(View.GONE);
                break;
        }