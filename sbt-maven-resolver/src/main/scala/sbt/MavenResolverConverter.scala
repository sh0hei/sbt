package sbt

import UpdateOptions.ResolverConverter
import org.apache.ivy.plugins.resolver.{ MavenCacheRepositoryResolver, MavenRemoteRepositoryResolver }

object MavenResolverConverter {
  val converter: ResolverConverter = {
    case (cache: MavenCache, settings, log) =>
      new MavenCacheRepositoryResolver(cache, settings)
    case (repo: MavenRepository, settings, log) =>
      new MavenRemoteRepositoryResolver(repo, settings)
  }
}
