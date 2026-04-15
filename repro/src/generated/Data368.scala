package generated

final case class Data368(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data368 = copy(name = name.toUpperCase)
  def scale(k: Double): Data368 = copy(value = value * k)
  def addTag(t: String): Data368 = copy(tags = t :: tags)
  def put(k: String, v: String): Data368 = copy(meta = meta.updated(k, v))
  def merge(other: Data368): Data368 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data368 {
  given Ordering[Data368] = Ordering.by(_.id)
  def empty: Data368 = Data368(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data368 =
    Data368(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data368] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
