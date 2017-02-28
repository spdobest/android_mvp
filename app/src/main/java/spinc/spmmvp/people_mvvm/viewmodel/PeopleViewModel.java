/**
 * Copyright 2016 Erik Jhordan Rey. <p/> Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at <p/> http://www.apache.org/licenses/LICENSE-2.0 <p/> Unless required by
 * applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See
 * the License for the specific language governing permissions and limitations under the License.
 */

package spinc.spmmvp.people_mvvm.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import spinc.spmmvp.R;
import spinc.spmmvp.people_mvvm.PeopleApplication;
import spinc.spmmvp.people_mvvm.data.PeopleResponse;
import spinc.spmmvp.people_mvvm.data.PeopleService;
import spinc.spmmvp.people_mvvm.model.People;

public class PeopleViewModel extends Observable {

  public ObservableInt peopleProgress;
  public ObservableInt peopleRecycler;
  public ObservableInt peopleLabel;
  public ObservableField<String> messageLabel;

  private List<People> peopleList;
  private Context context;
  private Subscription subscription;

  public PeopleViewModel(@NonNull Context context) {
    this.context = context;
    this.peopleList = new ArrayList<>();
    peopleProgress = new ObservableInt(View.GONE);
    peopleRecycler = new ObservableInt(View.GONE);
    peopleLabel = new ObservableInt(View.VISIBLE);
    messageLabel = new ObservableField<>(context.getString(R.string.default_loading_people));
  }

  public void onClickFabLoad(View view) {
    initializeViews();
    fetchPeopleList();
  }

  //It is "public" to show an example of test
  public void initializeViews() {
    peopleLabel.set(View.GONE);
    peopleRecycler.set(View.GONE);
    peopleProgress.set(View.VISIBLE);
  }

  private void fetchPeopleList() {

    final String URL = "http://api.randomuser.me/?results=10&nat=en";
    unSubscribeFromObservable();
    PeopleApplication peopleApplication = PeopleApplication.create(context);
    PeopleService peopleService = peopleApplication.getPeopleService();
    subscription = peopleService.fetchPeople(URL)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(peopleApplication.subscribeScheduler())
        .subscribe(new Action1<PeopleResponse>() {
          @Override
          public void call(PeopleResponse peopleResponse) {
            peopleProgress.set(View.GONE);
            peopleLabel.set(View.GONE);
            peopleRecycler.set(View.VISIBLE);
            changePeopleDataSet(peopleResponse.getPeopleList());
          }
        }, new Action1<Throwable>() {
          @Override
          public void call(Throwable throwable) {
            throwable.printStackTrace();
            messageLabel.set(context.getString(R.string.error_loading_people));
            peopleProgress.set(View.GONE);
            peopleLabel.set(View.VISIBLE);
            peopleRecycler.set(View.GONE);
          }
        });
  }

  private void changePeopleDataSet(List<People> peoples) {
    peopleList.addAll(peoples);
    setChanged();
    notifyObservers();
  }

  public List<People> getPeopleList() {
    return peopleList;
  }

  private void unSubscribeFromObservable() {
    if (subscription != null && !subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }

  public void reset() {
    unSubscribeFromObservable();
    subscription = null;
    context = null;
  }
}
