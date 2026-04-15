package generated

final case class Data940(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data940 = copy(name = name.toUpperCase)
  def scale(k: Double): Data940 = copy(value = value * k)
  def addTag(t: String): Data940 = copy(tags = t :: tags)
  def put(k: String, v: String): Data940 = copy(meta = meta.updated(k, v))
  def merge(other: Data940): Data940 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data940 {
  given Ordering[Data940] = Ordering.by(_.id)
  def empty: Data940 = Data940(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data940 =
    Data940(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data940] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
