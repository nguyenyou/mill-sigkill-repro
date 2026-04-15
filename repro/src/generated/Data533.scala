package generated

final case class Data533(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data533 = copy(name = name.toUpperCase)
  def scale(k: Double): Data533 = copy(value = value * k)
  def addTag(t: String): Data533 = copy(tags = t :: tags)
  def put(k: String, v: String): Data533 = copy(meta = meta.updated(k, v))
  def merge(other: Data533): Data533 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data533 {
  given Ordering[Data533] = Ordering.by(_.id)
  def empty: Data533 = Data533(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data533 =
    Data533(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data533] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
