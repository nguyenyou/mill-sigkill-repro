package generated

final case class Data151(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data151 = copy(name = name.toUpperCase)
  def scale(k: Double): Data151 = copy(value = value * k)
  def addTag(t: String): Data151 = copy(tags = t :: tags)
  def put(k: String, v: String): Data151 = copy(meta = meta.updated(k, v))
  def merge(other: Data151): Data151 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data151 {
  given Ordering[Data151] = Ordering.by(_.id)
  def empty: Data151 = Data151(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data151 =
    Data151(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data151] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
