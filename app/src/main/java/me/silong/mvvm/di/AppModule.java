/*
 * Copyright(c) 2016 "Si Long <long.bkiter07@gmail.com>"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package me.silong.mvvm.di;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.silong.mvvm.data.di.DataModule;
import me.silong.mvvm.domain.di.DomainModule;

/**
 * Created by SILONG on 4/13/16.
 */
@Module(includes = {DataModule.class, DomainModule.class})
public class AppModule {

  private Application mApp;

  public AppModule(Application app) {
    mApp = app;
  }

  @Provides
  @Singleton
  @AppContext
  public Context provideAppContext() {
    return mApp;
  }

  @Provides
  @Singleton
  public Resources provideResource(@AppContext Context context) {
    return context.getResources();
  }

}
