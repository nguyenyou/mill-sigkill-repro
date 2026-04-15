package generated

final case class Data877(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data877 = copy(name = name.toUpperCase)
  def scale(k: Double): Data877 = copy(value = value * k)
  def addTag(t: String): Data877 = copy(tags = t :: tags)
  def put(k: String, v: String): Data877 = copy(meta = meta.updated(k, v))
  def merge(other: Data877): Data877 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data877 {
  given Ordering[Data877] = Ordering.by(_.id)
  def empty: Data877 = Data877(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data877 =
    Data877(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data877] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
