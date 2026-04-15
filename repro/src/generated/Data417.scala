package generated

final case class Data417(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data417 = copy(name = name.toUpperCase)
  def scale(k: Double): Data417 = copy(value = value * k)
  def addTag(t: String): Data417 = copy(tags = t :: tags)
  def put(k: String, v: String): Data417 = copy(meta = meta.updated(k, v))
  def merge(other: Data417): Data417 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data417 {
  given Ordering[Data417] = Ordering.by(_.id)
  def empty: Data417 = Data417(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data417 =
    Data417(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data417] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
