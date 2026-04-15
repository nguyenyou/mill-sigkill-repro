package generated

final case class Data723(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data723 = copy(name = name.toUpperCase)
  def scale(k: Double): Data723 = copy(value = value * k)
  def addTag(t: String): Data723 = copy(tags = t :: tags)
  def put(k: String, v: String): Data723 = copy(meta = meta.updated(k, v))
  def merge(other: Data723): Data723 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data723 {
  given Ordering[Data723] = Ordering.by(_.id)
  def empty: Data723 = Data723(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data723 =
    Data723(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data723] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
