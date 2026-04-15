package generated

final case class Data472(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data472 = copy(name = name.toUpperCase)
  def scale(k: Double): Data472 = copy(value = value * k)
  def addTag(t: String): Data472 = copy(tags = t :: tags)
  def put(k: String, v: String): Data472 = copy(meta = meta.updated(k, v))
  def merge(other: Data472): Data472 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data472 {
  given Ordering[Data472] = Ordering.by(_.id)
  def empty: Data472 = Data472(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data472 =
    Data472(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data472] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
