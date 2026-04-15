package generated

final case class Data407(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data407 = copy(name = name.toUpperCase)
  def scale(k: Double): Data407 = copy(value = value * k)
  def addTag(t: String): Data407 = copy(tags = t :: tags)
  def put(k: String, v: String): Data407 = copy(meta = meta.updated(k, v))
  def merge(other: Data407): Data407 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data407 {
  given Ordering[Data407] = Ordering.by(_.id)
  def empty: Data407 = Data407(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data407 =
    Data407(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data407] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
