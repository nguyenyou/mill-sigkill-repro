package generated

final case class Data168(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data168 = copy(name = name.toUpperCase)
  def scale(k: Double): Data168 = copy(value = value * k)
  def addTag(t: String): Data168 = copy(tags = t :: tags)
  def put(k: String, v: String): Data168 = copy(meta = meta.updated(k, v))
  def merge(other: Data168): Data168 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data168 {
  given Ordering[Data168] = Ordering.by(_.id)
  def empty: Data168 = Data168(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data168 =
    Data168(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data168] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
