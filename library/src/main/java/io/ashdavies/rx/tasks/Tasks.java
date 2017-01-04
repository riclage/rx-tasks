package io.ashdavies.rx.tasks;

import com.google.android.gms.tasks.Task;
import io.reactivex.Completable;
import io.reactivex.Single;

public class Tasks {

  private Tasks() {
    throw new IllegalStateException("No instances");
  }

  public static Completable completable(Task<Void> task) {
    return Completable.create(new CompletableTaskOnSubscribe(task));
  }

  public static <T> Single<T> single(final Task<T> task) {
    return Single.create(new SingleTaskOnSubscribe<>(task));
  }
}