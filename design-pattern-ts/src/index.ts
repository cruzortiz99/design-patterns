export function main ( ...args: string[] ) {
	console.log( ...args.slice( 2 ) )
}

main( ...process.argv )