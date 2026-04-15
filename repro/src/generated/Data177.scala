package generated

final case class Data177(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data177 = copy(name = name.toUpperCase)
  def scale(k: Double): Data177 = copy(value = value * k)
  def addTag(t: String): Data177 = copy(tags = t :: tags)
  def put(k: String, v: String): Data177 = copy(meta = meta.updated(k, v))
  def merge(other: Data177): Data177 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data177 {
  given Ordering[Data177] = Ordering.by(_.id)
  def empty: Data177 = Data177(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data177 =
    Data177(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data177] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
