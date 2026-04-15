package generated

final case class Data415(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data415 = copy(name = name.toUpperCase)
  def scale(k: Double): Data415 = copy(value = value * k)
  def addTag(t: String): Data415 = copy(tags = t :: tags)
  def put(k: String, v: String): Data415 = copy(meta = meta.updated(k, v))
  def merge(other: Data415): Data415 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data415 {
  given Ordering[Data415] = Ordering.by(_.id)
  def empty: Data415 = Data415(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data415 =
    Data415(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data415] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
