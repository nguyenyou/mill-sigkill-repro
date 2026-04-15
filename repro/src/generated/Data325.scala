package generated

final case class Data325(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data325 = copy(name = name.toUpperCase)
  def scale(k: Double): Data325 = copy(value = value * k)
  def addTag(t: String): Data325 = copy(tags = t :: tags)
  def put(k: String, v: String): Data325 = copy(meta = meta.updated(k, v))
  def merge(other: Data325): Data325 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data325 {
  given Ordering[Data325] = Ordering.by(_.id)
  def empty: Data325 = Data325(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data325 =
    Data325(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data325] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
