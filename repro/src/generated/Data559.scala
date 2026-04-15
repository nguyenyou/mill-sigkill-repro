package generated

final case class Data559(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data559 = copy(name = name.toUpperCase)
  def scale(k: Double): Data559 = copy(value = value * k)
  def addTag(t: String): Data559 = copy(tags = t :: tags)
  def put(k: String, v: String): Data559 = copy(meta = meta.updated(k, v))
  def merge(other: Data559): Data559 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data559 {
  given Ordering[Data559] = Ordering.by(_.id)
  def empty: Data559 = Data559(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data559 =
    Data559(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data559] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
