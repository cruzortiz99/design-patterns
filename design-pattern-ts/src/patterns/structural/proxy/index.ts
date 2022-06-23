export interface ServiceInterface {
  addServicePrefix ( word: string ): string
}
export class Service implements ServiceInterface {
  private prefix: string
  constructor ( prefix: string ) {
    this.prefix = prefix
  }
  addServicePrefix ( word: string ): string {
    return `${this.prefix}-${word}`
  }
}
export class ServiceCacheFactory {
  private static instance: ServiceCacheFactory | undefined
  static create (): ServiceCacheFactory {
    if ( !ServiceCacheFactory.instance ) {
      ServiceCacheFactory.instance = new ServiceCacheFactory()
    }
    return ServiceCacheFactory.instance
  }
  private cache: Record<string, any>
  private constructor () {
    this.cache = {}
  }
  isCached ( paramsString: string ): boolean {
    return !!this.cache[paramsString]
  }
  saveInCache<T> ( paramsString: string, value: T ): T {
    this.cache[paramsString] = value
    return value
  }
  getInCache<T> ( paramsString: string ): T {
    return this.cache[paramsString]
  }
}

export class ServiceProxy implements ServiceInterface {
  private service: ServiceInterface
  private cacheFactory: ServiceCacheFactory
  constructor ( service: ServiceInterface ) {
    this.cacheFactory = ServiceCacheFactory.create()
    this.service = service
  }
  addServicePrefix ( word: string ): string {
    if ( this.cacheFactory.isCached( word ) ) {
      return this.cacheFactory.getInCache( word )
    }
    return this.cacheFactory.saveInCache(
      word, this.service.addServicePrefix( word ) )
  }

}