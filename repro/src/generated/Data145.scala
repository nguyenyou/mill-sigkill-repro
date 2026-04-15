package generated

final case class Data145(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data145 = copy(name = name.toUpperCase)
  def scale(k: Double): Data145 = copy(value = value * k)
  def addTag(t: String): Data145 = copy(tags = t :: tags)
  def put(k: String, v: String): Data145 = copy(meta = meta.updated(k, v))
  def merge(other: Data145): Data145 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data145 {
  given Ordering[Data145] = Ordering.by(_.id)
  def empty: Data145 = Data145(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data145 =
    Data145(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data145] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
