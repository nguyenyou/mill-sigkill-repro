package generated

final case class Data284(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data284 = copy(name = name.toUpperCase)
  def scale(k: Double): Data284 = copy(value = value * k)
  def addTag(t: String): Data284 = copy(tags = t :: tags)
  def put(k: String, v: String): Data284 = copy(meta = meta.updated(k, v))
  def merge(other: Data284): Data284 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data284 {
  given Ordering[Data284] = Ordering.by(_.id)
  def empty: Data284 = Data284(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data284 =
    Data284(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data284] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
