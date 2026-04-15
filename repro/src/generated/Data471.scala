package generated

final case class Data471(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data471 = copy(name = name.toUpperCase)
  def scale(k: Double): Data471 = copy(value = value * k)
  def addTag(t: String): Data471 = copy(tags = t :: tags)
  def put(k: String, v: String): Data471 = copy(meta = meta.updated(k, v))
  def merge(other: Data471): Data471 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data471 {
  given Ordering[Data471] = Ordering.by(_.id)
  def empty: Data471 = Data471(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data471 =
    Data471(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data471] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
