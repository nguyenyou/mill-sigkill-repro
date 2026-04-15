package generated

final case class Data421(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data421 = copy(name = name.toUpperCase)
  def scale(k: Double): Data421 = copy(value = value * k)
  def addTag(t: String): Data421 = copy(tags = t :: tags)
  def put(k: String, v: String): Data421 = copy(meta = meta.updated(k, v))
  def merge(other: Data421): Data421 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data421 {
  given Ordering[Data421] = Ordering.by(_.id)
  def empty: Data421 = Data421(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data421 =
    Data421(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data421] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
