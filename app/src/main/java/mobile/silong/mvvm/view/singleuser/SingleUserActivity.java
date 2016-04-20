package mobile.silong.mvvm.view.singleuser;

import android.databinding.DataBindingUtil;

import mobile.silong.mvvm.Constant;
import mobile.silong.mvvm.R;
import mobile.silong.mvvm.databinding.ActivitySingleUserBinding;
import mobile.silong.mvvm.presentation.SingleUserViewModel;
import mobile.silong.mvvm.view.BaseActivity;
import mobile.silong.mvvm.view.singleuser.di.SingleUserModule;

public class SingleUserActivity extends BaseActivity<SingleUserViewModel> {

  @Override
  public void bindViewModel(SingleUserViewModel viewModel) {
    ActivitySingleUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_single_user);
    binding.setUserModel(viewModel);
  }

  @Override
  public SingleUserViewModel createViewModel() {
    return getAppComponent()
        .plus(new SingleUserModule(getIntent().getExtras().getString(Constant.Extra.EXTRA_USER_ID)))
        .getSingleUserViewModel();
  }
}