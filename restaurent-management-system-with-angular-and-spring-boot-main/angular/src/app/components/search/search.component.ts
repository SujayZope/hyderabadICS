import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged,switchMap} from 'rxjs/operators';
import { SearchService } from '../services/search-searvice';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  private searchKeySubject = new Subject<string>();


  constructor(private searchService:SearchService) { }

  ngOnInit() {
  }

}

export function liveSearch<T, R>(
  dataCb: (query: T) => Observable<R>,
  delay = 250
) {

  return (source$: Observable<T>) => source$.pipe(
    debounceTime(delay),
    distinctUntilChanged(),
    switchMap(dataCb)
  )

}
