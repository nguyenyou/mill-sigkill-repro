package generated

final case class Data251(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data251 = copy(name = name.toUpperCase)
  def scale(k: Double): Data251 = copy(value = value * k)
  def addTag(t: String): Data251 = copy(tags = t :: tags)
  def put(k: String, v: String): Data251 = copy(meta = meta.updated(k, v))
  def merge(other: Data251): Data251 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data251 {
  given Ordering[Data251] = Ordering.by(_.id)
  def empty: Data251 = Data251(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data251 =
    Data251(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data251] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
