export class DBConnection {
  private static instance: DBConnection | undefined
  private host: string
  private port: number
  private username: string
  private password: string
  private constructor (
    host: string,
    port: number,
    username: string,
    password: string
  ) {
    this.host = host
    this.port = port
    this.username = username
    this.password = password
  }
  static create (
    host: string,
    port: number,
    username: string,
    password: string
  ): DBConnection {
    if ( !DBConnection.instance ) {
      DBConnection.instance = new DBConnection( host, port, username, password )
      return DBConnection.instance
    }
    return DBConnection.instance
  }
  getHost (): string {
    return this.host
  }
  getPort (): number {
    return this.port
  }
  getUsername (): string {
    return this.username
  }
  getPassword (): string {
    return this.password
  }
}
