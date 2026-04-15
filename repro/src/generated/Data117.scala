package generated

final case class Data117(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data117 = copy(name = name.toUpperCase)
  def scale(k: Double): Data117 = copy(value = value * k)
  def addTag(t: String): Data117 = copy(tags = t :: tags)
  def put(k: String, v: String): Data117 = copy(meta = meta.updated(k, v))
  def merge(other: Data117): Data117 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data117 {
  given Ordering[Data117] = Ordering.by(_.id)
  def empty: Data117 = Data117(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data117 =
    Data117(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data117] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
